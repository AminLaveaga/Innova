angular.module("innovaFrontApp").controller('eventoCatalogoCtrl',['$scope','contratoService','cancionService','eventoService','$uibModal',
  function($scope,contratoService,cancionService,eventoService,$uibModal){

    $scope.contrato={
                        id:'',
                        nombreCliente:'',
                        telefonoCliente:'',
                        tipoEvento:'',
                        festejados:'',
                        fechaEvento:'',
                        lugar:'',
                        horaInicio:'',
                        duracionEvento:'',
                        cantidadTotal:'',
                        cantidadTotalTexto:'',
                        enganche:'',
                        resto:'',
                        fechaContratacion:'',
                        evento:{}

                      };

  $scope.evento={
                  actividad:[],
                  canciones:[]

  };
 $scope.fechaEvento='';
 var a=new Date();

$scope.canciones=[];
$scope.listaSeleccion=[];

$scope.idContrato="";

  $scope.boda=[
                {hora:"",nombre:"Inicia Grupo",informacion:""},
                {hora:"",nombre:"Presentacion novios",informacion:""},
                {hora:"",nombre:"Cena",informacion:""},
                {hora:"",nombre:"Música de fondo para cena",informacion:""},
                {hora:"",nombre:"Ramo y liga",informacion:""},
                {hora:"",nombre:"Batucada",involucrados:"",informacion:""},
                {hora:"",nombre:"Termina Grupo",informacion:""}

  ];
  $scope.quinceañera=[
                         {hora:"",nombre:"Inicia Grupo",informacion:""},
                         {hora:"",nombre:"Vals quinceañera",informacion:""},
                         {hora:"",nombre:"Cena",informacion:""},
                         {hora:"",nombre:"Música de fondo para cena",informacion:""},
                         {hora:"",nombre:"Flor",informacion:""},
                         {hora:"",nombre:"Batucada",involucrados:"",informacion:""},
                         {hora:"",nombre:"Termina Grupo",informacion:""}
  ];
    $scope.otro=[

            {hora:"",nombre:"Inicia grupo",informacion:""},
            {hora:"",nombre:"Termina Grupo",informacion:""}

    ];
    $scope.actividades=[];

$scope.traerId=function(){
 console.log("TRAER POR ID");

        contratoService.buscarPorId($scope.idContrato).then(function(resul){
        if(resul.data!=''){

                $scope.contrato=resul.data;
                            $scope.fechaEvento=new  Date(''+$scope.contrato.fechaEvento+'T07:00:00.000Z');
                            $scope.fechaContratacion= new Date(''+$scope.contrato.fechaContratacion+'T07:00:00.000Z');
                           /* for(var h=0;h<$scope.horas.length;h++){
                                                                     if(resul.data.hora==$scope.horas[h].hora){
                                                                              $scope.contrato.horaInicio=$scope.horas[h];
                                                                               break;
                                                                               };
                                                                 };*/
                            if(resul.data.evento.actividades==''){
                                //hora inicio
                                               document.getElementById("boton").disabled=false;
                                              var a= new Date("Thu May 03 2018 "+resul.data.horaInicio+":00");
                                              var b=new Date("Thu May 03 2018 "+resul.data.horaInicio+":00");;
                                              var horaInicio=resul.data.horaInicio;
                                              b.setHours(b.getHours()+resul.data.duracionEvento);
                                              var horaFin;
                                              if(b.getMinutes()==0){ horaFin=b.getHours()+":00";}else{horaFin=b.getHours()+":"+b.getMinutes();};


                                              //-----

                                           if(resul.data.tipoEvento=='Boda'){$scope.actividades=$scope.boda;};
                                           if(resul.data.tipoEvento=='XV'){$scope.actividades=$scope.quinceañera;};
                                            if(resul.data.tipoEvento!='XV' && resul.data.tipoEvento!='Boda'){$scope.actividades=$scope.otro;};
                                            $scope.actividades[0].hora=horaInicio;
                                             $scope.actividades[$scope.actividades.length-1].hora=horaFin;
                                             document.getElementById("agregarBoton").disabled=false;


                            }else{
                                    document.getElementById("botonEliminar").disabled=false;
                                    document.getElementById("boton").disabled=false;
                                    document.getElementById("agregarBoton").disabled=false;
                                    document.getElementById("boton").innerText="Modificar";
                                    $scope.actividades=resul.data.evento.actividades;
                                    $scope.listaSeleccion=resul.data.evento.canciones;
                                               };






        }else{alert("Contrato inexistente!");};



        },function(error){
              alert("no trajo no");
        });
};


$scope.cerrarVentana=function(){
        $uibModalInstance.close();
    };


$scope.agregarActividad=function(num){

var a={hora:"",nombre:"",informacion:""};
     num=num+1;

$scope.actividades.splice(num,0,a);
};

$scope.eliminarActividad=function(num){
  $scope.actividades.splice(num,1);
};

$scope.eliminarCancion=function(num){
  $scope.listaSeleccion.splice(num,1);
};


//$scope.traerId(obj.idContrato);

$scope.listarCanciones=function(){
      cancionService.listarCanciones().then(function(result){
            $scope.canciones=result.data;
      },function(error){});
};

$scope.listarCanciones();

 $scope.evento={
                        actividades:[],
                        canciones:[],
                        contrato:{}
          };
//guardar
$scope.guardar=function(){


          $scope.contrato.evento.actividades= $scope.actividades;
          $scope.contrato.evento.canciones=$scope.listaSeleccion;
          contratoService.modificarContrato($scope.contrato).then(function(resul){

                                  console.log("SI SE PUDO");
                                  $scope.contrato=$scope.contrato={
                                                                      id:'',
                                                                      nombreCliente:'',
                                                                      telefonoCliente:'',
                                                                      tipoEvento:'',
                                                                      festejados:'',
                                                                      fechaEvento:'',
                                                                      lugar:'',
                                                                      horaInicio:'',
                                                                      duracionEvento:'',
                                                                      cantidadTotal:'',
                                                                      cantidadTotalTexto:'',
                                                                      enganche:'',
                                                                      resto:'',
                                                                      fechaContratacion:'',
                                                                      evento:{}

                                                                    };
                                      $scope.actividades=[];
                                      $scope.listaSeleccion=[];
                                      document.getElementById("boton").innerText="Guardar";
                                      document.getElementById("agregarBoton").disabled=true;
                                     // $scope.cerrarVentana();
                                      //$scope.$parent.consultarContratos();


                                  },function(error){console.log("NO SE PUDO GUARDAR");});


};
$scope.eliminar=function(){
$scope.contrato.evento.actividades=[];
          $scope.contrato.evento.canciones=[];
          contratoService.modificarContrato($scope.contrato).then(function(resul){

                                  console.log("SI SE PUDO");
                                  $scope.contrato=$scope.contrato={
                                                                      id:'',
                                                                      nombreCliente:'',
                                                                      telefonoCliente:'',
                                                                      tipoEvento:'',
                                                                      festejados:'',
                                                                      fechaEvento:'',
                                                                      lugar:'',
                                                                      horaInicio:'',
                                                                      duracionEvento:'',
                                                                      cantidadTotal:'',
                                                                      cantidadTotalTexto:'',
                                                                      enganche:'',
                                                                      resto:'',
                                                                      fechaContratacion:'',
                                                                      evento:{}

                                                                    };
                                      //$scope.actividades=[];
                                      //$scope.listaSeleccion=[];
                                      document.getElementById("boton").innerText="Guardar";
                                      document.getElementById("botonEliminar").disabled=true;
                                      document.getElementById("boton").disabled=true;
                                      document.getElementById("agregarBoton").disabled=true;
                                      $scope.cerrarVentana();
                                      $scope.$parent.consultarContratos();


                                  },function(error){console.log("NO SE PUDO GUARDAR");});

};


$scope.modalRepertorio=function(){

   var modalInstance=$uibModal.open({

            templateUrl:'views/listaCanciones.html',
            controller:'playListCtrl',
            scope:$scope,
            size:'lg',
            backdrop:'static',
            resolve:{
                  obj:function(){
                      return{}
                  }
            }
        });

};
///seleccionar generos repertorio
$scope.indexedGenero = [];

    $scope.cancionesAFiltrar = function() {
        indexedGenero = [];
        return $scope.canciones;
    }

    $scope.filtrarGeneros = function(cancion) {

        var generoNuevo = indexedGenero.indexOf(cancion.genero) == -1;
        if (generoNuevo) {
            indexedGenero.push(cancion.genero);
        }
        return generoNuevo;
    }
//generossss

///seleccionar generos selecciones
$scope.indexedGeneroSeleccion = [];

    $scope.cancionesAFiltrarSeleccion = function() {
        indexedGeneroSeleccion = [];
        return $scope.listaSeleccion;
    }

    $scope.filtrarGenerosSeleccion = function(cancion) {

        var generoNuevo = indexedGeneroSeleccion.indexOf(cancion.genero) == -1;
        if (generoNuevo) {
            indexedGeneroSeleccion.push(cancion.genero);
        }
        return generoNuevo;
    }
//generossss

}]);
