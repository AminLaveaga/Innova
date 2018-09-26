angular.module('innovaFrontApp').controller('cancionCtrl',['$scope','cancionService',function($scope,cancionService){
$scope.cancion={
                  id:'',
                  nombre:'',
                  interprete:'',
                  genero:''
};
$scope.canciones=[];

$scope.guardarCancion=function(){

          cancionService.guardarCancion($scope.cancion).then(function(result){$scope.listarCanciones();},function(error){});
          $scope.cancion={
                            id:'',
                            nombre:'',
                            interprete:'',
                            genero:''
          };
};

$scope.listarCanciones=function(){

      cancionService.listarCanciones().then(function(result){
                    $scope.canciones=result.data;
      },function(error){});
};

$scope.eliminarCancion=function(id){

      cancionService.eliminarPorId(id).then(function(result){$scope.listarCanciones();
          $scope.cancion={
                                      id:'',
                                      nombre:'',
                                      interprete:'',
                                      genero:''
                                             };
      },function(error){});
};

$scope.modificarCancion=function(){

          cancionService.modificarCancion($scope.cancion).then(function(result){

           $scope.cancion={
                            id:'',
                            nombre:'',
                            interprete:'',
                            genero:''
                                   };
           $scope.listarCanciones();
                                   },function(error){});

};
$scope.traerPorId=function(id){

       cancionService.buscarPorId(id).then(function(result){
              $scope.cancion=result.data;
       },function(error){});
};
$scope.listarCanciones();

}]);
