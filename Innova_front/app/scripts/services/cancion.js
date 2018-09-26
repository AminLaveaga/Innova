
 angular.module('innovaFrontApp').service('cancionService',['$http',function($http){


    this.guardarCancion = function(cancion){
               return $http({method:'POST',url:'http://localhost:8080/cancion',data:cancion});
       };
    this.modificarCancion = function(cancion){
                   return $http({method:'PUT',url:'http://localhost:8080/cancion',data:cancion});
     };
    this.eliminarPorId=function(id){
           return $http({method:'DELETE',url:'http://localhost:8080/cancion/eliminar/idcancion/'+id});
    };

    this.buscarPorId=function(id){
                return $http({method:'GET',url:'http://localhost:8080/cancion/buscar/idcancion/'+id});
        };
     this.buscarPorNombre=function(nombre){
                return $http({method:'GET',url:'http://localhost:8080/cancion/buscar/nombrecancion/'+nombre});
      };
     this.buscarPorInterpreto=function(interprete){
                return $http({method:'GET',url:'http://localhost:8080/cancion/buscar/interpretecancion/'+interprete});
      };
    this.listarCanciones=function(){
                    return $http({method:'GET',url:'http://localhost:8080/cancion/buscar'});
          };

 }]);
