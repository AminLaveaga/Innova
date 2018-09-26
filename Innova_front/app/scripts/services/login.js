angular.module('innovaFrontApp').service('loginService',['$http','$rootScope',function($http,$rootScope){


   this.login = function(usuario){
              return $http(
                            {
                                method:'POST',
                                url:'http://localhost:8080/user/login',
                                data:usuario /*,
                                transformRequest: angular.identity,

                                    headers: {
                                                'Content-Type': undefined
                                              }
                                              */

                             });
      };



/*
   this.login = function(usuario){
        return $http({
              url: 'http://localhost:8080/login',
              method: "POST",
              data:$.param( { username: usuario.username, password:usuario.password}),
              headers: {'Content-Type': 'application/x-www-form-urlencoded',Authorization: 'Basic YW5kcm9pZC1jYWxjdWxhZG9ydGk6MTIzNDU2' }
          });


      };
      */


}]);
