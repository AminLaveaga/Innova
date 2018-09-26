angular.module('innovaFrontApp').controller('agendaCtrl',['$scope','uiCalendarConfig','contratoService','$http','$uibModal',function(
$scope,uiCalendarConfig,contratoService,$http,$uibModal){

    $scope.SelectedEvent = null;
    var isFirstTime = true;
    $scope.events = [];
    $scope.eventSources = [$scope.events];

    $scope.NewEvent = {};
    //this function for get datetime from json date
    function getDate(datetime) {
        if (datetime != null) {
            var mili = datetime.replace(/\/Date\((-?\d+)\)\//, '$1');
            return new Date(parseInt(mili));
        }
        else {
            return "";
        }
    }
    // this function clears clender enents
    function clearCalendar() {
        if (uiCalendarConfig.calendars.myCalendar != null) {
            uiCalendarConfig.calendars.myCalendar.fullCalendar('removeEvents');
            uiCalendarConfig.calendars.myCalendar.fullCalendar('unselect');
        }
    }
    //Load events from server to display on caledar
    function populate() {
        clearCalendar();
       /* $http.get('http://localhost:8080/contrato/obtenerEventos', {
            cache: false,
            params: {}
        })*/contratoService.obtenerEventos().then(function (data) {

        //$scope.events = data.data

           // $scope.events.slice(0, $scope.events.length);
           angular.forEach(data.data, function (value) {

                  var end=new Date(value.start);
                  end.setHours(end.getHours()+value.cantidad);

                $scope.events.push({
                    id : value.id,
                    title: value.title,
                    description: value.description,
                    start: new Date(value.start),
                    end: end,
                    allDay: value.allDay,
                    stick: true
                });
            });
        });



    }
    populate();
    //UI- calendar configuration
    $scope.uiConfig = {
        calendar: {
            height: 450,
            editable: false,
            displayEventTime: true,
            lang:'es',
            header: {
                left: 'month,agendaWeek,agendaDay',
                center: 'title',
                right:'today prev,next'
            },
           /* timeFormat : {
                month : ' ', // for hide on month view
                agenda: 'h:mm t'
            },*/
            selectable: true,
            selectHelper: true,
            select : function(start, end){
                var fromDate = moment(start).format('YYYY/MM/DD LT');
                var endDate = moment(end).format('YYYY/MM/DD LT');
                $scope.NewEvent = {
                    EventID : 0,
                    StartAt : fromDate,
                    EndAt : endDate,
                    IsFullDay :false,
                    Title : '',
                    Description : ''
                }

               // $scope.ShowModal();
            },
            eventClick: function (event) {
                $scope.SelectedEvent = event;
                var fromDate = moment(event.start).format('YYYY/MM/DD LT');
                var endDate = moment(event.end).format('YYYY/MM/DD LT');
                $scope.NewEvent = {
                    EventID : event.id,
                    StartAt : fromDate,
                    EndAt : endDate,
                    IsFullDay :false,
                    Title : event.title,
                    Description : event.description
                }
                $scope.observarModal(event.id);
                //$scope.ShowModal();
            },
            eventAfterAllRender: function () {
                if ($scope.events.length > 0 && isFirstTime) {
                    uiCalendarConfig.calendars.myCalendar.fullCalendar('gotoDate', $scope.events[0].start);
                    isFirstTime = false;
                }
            }
        }
    };

$scope.observarModal=function(id){

    var modalInstance=$uibModal.open({

        templateUrl:'views/observarContratoAgenda.html',
        controller:'observarContratoAgendaCtrl',
        scope:$scope,
        size:'lg',
        backdrop:'static',
        resolve:{
              obj:function(){
                  return{idContrato:id}
              }
        }
    });

};
















}]);
