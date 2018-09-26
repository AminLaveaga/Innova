
angular.module('innovaFrontApp').service('eventoService',['$http',function($http){

    this.guardarEvento= function(evento){
          return $http({method:'PUT',url:'http://localhost:8080/evento',data:evento});
    };

    this.buscarPorId=function(id){
                return $http({method:'GET',url:'http://localhost:8080/evento/buscar/idcontrato/'+id});
        };

}]);
