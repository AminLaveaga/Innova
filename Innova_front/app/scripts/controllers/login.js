angular.module('innovaFrontApp').controller('loginCtrl',['$scope','$rootScope','loginService',function($scope,$rootScope,loginService){

    $scope.usuario={email:'InnovaAdmin',
                    password:'InnovaAyon'
    };

    $scope.login=function(){
          loginService.login($scope.usuario).then(function(result){
          //console.log('RESULTADO: '+ JSON.stringify(result));
          //console.log(result.data.json().headers()['Authorization']);
                          //alert('loginnnnnnn' +  result.headers()['Authorization']);
         // alert('loginnnnnnn' + JSON.stringify( result.headers()));
              $rootScope.token="Bearer "+result.data.token;
              alert('loginnnnnnn' + $rootScope.token);

          },function(error){
          alert('Usuario o contraseña incorrecta');

          });
    };


}]);
