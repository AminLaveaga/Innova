
angular.module('innovaFrontApp').service('contratoService',['$http','$rootScope',function($http,$rootScope){

    this.guardarContrato = function(contrato){
            return $http({method:'POST',url:'http://localhost:8080/contrato',data:contrato,headers:{Authorization:$rootScope.token}});
    };
    this.modificarContrato = function(contrato){
                return $http({method:'PUT',url:'http://localhost:8080/contrato',data:contrato,headers:{Authorization:$rootScope.token}});
    };
    this.buscarPorId=function(id){
            return $http({method:'GET',url:'http://localhost:8080/contrato/id/'+id,headers:{Authorization:$rootScope.token}});
    };
    this.eliminarPorId=function(id){
                return $http({method:'DELETE',url:'http://localhost:8080/contrato/eliminar/id/'+id,headers:{Authorization:$rootScope.token}});
    };

     this.buscarPorFecha=function(fecha){
                 return $http({method:'GET',url:'http://localhost:8080/contrato/fecha/'+fecha,headers:{Authorization:$rootScope.token}});
      };

     this.consultarContratos=function(){
                  return $http({method:'GET',url:'http://localhost:8080/contrato/buscar',headers:{Authorization:$rootScope.token}});
          };


     this.obtenerEventos=function(){
                  return $http({method:'GET',url:'http://localhost:8080/contrato/obtenerEventos',headers:{Authorization:$rootScope.token}});
          };

      this.imprimirContrato= function (idcontrato){
              return $http.get('http://localhost:8080/contrato/reporte/id/'+idcontrato,{responseType:'arraybuffer'});
        };

}]);
