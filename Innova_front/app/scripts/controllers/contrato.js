

angular.module('innovaFrontApp').controller('contratoCtrl',['$scope','contratoService','$uibModal',function($scope,contratoService,$uibModal){

    $scope.horas=[
                                        {hora:'06:00'},{hora:'06:30'},{hora:'07:00'},
                                        {hora:'07:30'},{hora:'08:00'},{hora:'08:30'},
                                        {hora:'09:00'},{hora:'09:30'},{hora:'10:00'},
                                        {hora:'10:30'},{hora:'11:00'},{hora:'11:30'},
                                        {hora:'12:00'},{hora:'12:30'},{hora:'13:00'},
                                        {hora:'13:30'},{hora:'14:00'},{hora:'14:30'},
                                        {hora:'15:00'},{hora:'15:30'},{hora:'16:00'},
                                        {hora:'16:30'},{hora:'17:00'},{hora:'17:30'},
                                        {hora:'18:00'},{hora:'18:30'},{hora:'19:00'},
                                        {hora:'19:30'},{hora:'20:00'},{hora:'20:30'},
                                        {hora:'21:00'},{hora:'21:30'},{hora:'22:00'},
                                        {hora:'22:30'},{hora:'23:00'},{hora:'23:30'},
                                        {hora:'00:00'},{hora:'00:30'},{hora:'01:00'},
                                        {hora:'01:30'},{hora:'02:00'},{hora:'02:30'},
                                        {hora:'03:00'}
  ];

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

  $scope.contratos=[];

   var costoTotalInt=0;
   var engancheInt=0;
   var resto=0;
   $scope.fechaEvento='';
   $scope.fechaContratacion=new Date();

   $scope.prueba="Esta es la Variable de Prueba";

//CAMBIAR FORMATO DE LOS NUMEROS

function number_format(amount, decimals) {

    amount += ''; // por si pasan un numero en vez de un string
    amount = parseFloat(amount.replace(/[^0-9\.]/g, '')); // elimino cualquier cosa que no sea numero o punto

    decimals = decimals || 0; // por si la variable no fue fue pasada

    // si no es un numero o es igual a cero retorno el mismo cero
    if (isNaN(amount) || amount === 0)
        return parseFloat(0).toFixed(decimals);

    // si es mayor o menor que cero retorno el valor formateado como numero
    amount = '' + amount.toFixed(decimals);

    var amount_parts = amount.split('.'),
        regexp = /(\d+)(\d{3})/;

    while (regexp.test(amount_parts[0]))
        amount_parts[0] = amount_parts[0].replace(regexp, '$1' + ',' + '$2');

    return amount_parts.join('.');
};
/////////////////////////////////////////////////////////////////////////////////////////////
////////////QUITAR COMAS
function quitarComas(cadena){
        var entero="";

    for(i=0;i<cadena.length;i++){

        if(cadena.charCodeAt(i)>=47&&cadena.charCodeAt(i)<=58){
              entero=entero+cadena.charAt(i);
        };
    };
    return parseInt(entero);
};

//$scope.activarInput

/////////////////////////////////////////////
////FORMATO COSTOTOTAL////
$scope.formato_costoTotal=function(){
        var valor=document.getElementById('costototal').value;
        var decimal=0;
        $scope.contrato.cantidadTotal=number_format(valor,decimal);
      // document.getElementById('costototal').value=number_format(valor,decimal);
        console.log($scope.contrato.cantidadTotal+"");
        costoTotalInt=quitarComas($scope.contrato.cantidadTotal);
         console.log("Este es el costototalINT: "+ costoTotalInt);
         if(costoTotalInt>=4000){
            document.getElementById('enganche').disabled=false;}else{
                    document.getElementById('enganche').disabled=true;
                    $scope.contrato.enganche='0';
            };
};

///FORMATO ENGANCHE
$scope.formato_enganche=function(){
        var valor=document.getElementById('enganche').value;
        var decimal=0;
        $scope.contrato.enganche=number_format(valor,decimal);
      // document.getElementById('costototal').value=number_format(valor,decimal);
      engancheInt=quitarComas($scope.contrato.enganche);
               console.log("Este es el entero: "+engancheInt);
               formato_resto();


};
///////////////////
////////////FORMATO RESTO
function formato_resto(){
        if(costoTotalInt>=engancheInt){
           resto=costoTotalInt-engancheInt;
           $scope.contrato.resto=number_format(resto+'',0);
        }else{
              $scope.contrato.enganche='';
              $scope.contrato.resto='';
              alert("El enganche era mayor al costo total.");
        };
};

/////////////////////////
$scope.guardar=function(){

      if(document.getElementById("boton").innerText=="Guardar"){

        $scope.contrato.fechaEvento=$scope.fechaEvento;
              $scope.contrato.fechaContratacion=$scope.fechaContratacion;
              contratoService.guardarContrato($scope.contrato).then(function(resul){
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
                $scope.consultarContratos();

              },function(error){console.log("NO SE PUDO GUARDAR");});
      }else{
                        $scope.contrato.fechaEvento=$scope.fechaEvento;
                        $scope.contrato.fechaContratacion=$scope.fechaContratacion;
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
                            document.getElementById("boton").innerText="Guardar";
                            $scope.consultarContratos();


                        },function(error){console.log("NO SE PUDO GUARDAR");});
      };

      $scope.fechaEvento='';
      $scope.fechaContratacion=new Date();
      $scope.consultarContratos();

};




$scope.traerId=function(id){
 console.log("TRAER POR ID");
        document.getElementById("boton").innerText="Modificar";
        contratoService.buscarPorId(id).then(function(resul){
              $scope.contrato=resul.data;
              $scope.fechaEvento=new  Date(''+$scope.contrato.fechaEvento+'T07:00:00.000Z');
              $scope.fechaContratacion= new Date(''+$scope.contrato.fechaContratacion+'T07:00:00.000Z');
              for(var h=0;h<$scope.horas.length;h++){
                                                       if(resul.data.hora==$scope.horas[h].hora){
                                                                $scope.contrato.horaInicio=$scope.horas[h];
                                                                 break;
                                                                 };
                                                   };

            console.log('este es evento--------'+$scope.contrato.evento);
        },function(error){
              alert("no trajo no");
        });
};

$scope.eliminarId=function(id){

      contratoService.eliminarPorId(id).then(function(resul){$scope.consultarContratos();},function(error){});
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

};

function verDias(mes,ano){
    di=28
    f = new Date(ano,mes-1,di);
    while(f.getMonth()==mes-1){
    di++;
    f = new Date(ano,mes-1,di);
    console.log(f +"");
    }
    console.log(di-1 +"cantidad de dias");
};

$scope.consultarContratos=function(){

        contratoService.consultarContratos().then(function(resul){
            $scope.contratos=resul.data;

        },function(error){});

};

$scope.observarModal=function(id){

    var modalInstance=$uibModal.open({

        templateUrl:'views/observarContrato.html',
        controller:'observarContratoCtrl',
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

$scope.consultarContratos();

$scope.crearEvento=function(id){

     var modalInstance=$uibModal.open({

            templateUrl:'views/Evento.html',
            controller:'eventoCtrl',
            scope:$scope,

            backdrop:'static',
            resolve:{
                  obj:function(){
                      return{idContrato:id}
                  }
            }
        });
};

$scope.imprimirContrato=function(id){

     contratoService.imprimirContrato(id).then(
           function(result){

            var a = document.createElement("a");
              var file = new Blob([result.data],{type:'application/pdf'});
              var fileURL = URL.createObjectURL(file);
             // window.open(fileURL);
                              a.href = fileURL;
                              a.download = "contrato.pdf";
                              a.click();
          	 // growl.success("Reporte Generado con Exito ",{disableCountDown:true});
          	 alert("Reporte Generado con Exito");
           },function(result){
           	//growl.warning("Error al Mostrar el Reporte ",{disableCountDown:true});
           	alert("Error al Mostrar el Reporte");
           });

};



}]);
