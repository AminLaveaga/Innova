angular.module('innovaFrontApp').controller('playListCtrl',['$scope','$uibModalInstance',function($scope,$uibModalInstance){

$scope.cerrarVentana=function(){
        $uibModalInstance.close();
    };
$scope.genero="genero";


}]);
