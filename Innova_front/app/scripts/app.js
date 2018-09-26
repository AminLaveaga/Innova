'use strict';
/**
 * @ngdoc overview
 * @name innovaFrontApp
 * @description
 * # innovaFrontApp
 *
 * Main module of the application.
 */
angular
  .module('innovaFrontApp',[
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap',
    'ui.calendar',
    'checklist-model'
  ])
  .config(function ($routeProvider,$locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider

      .when('/', {
        templateUrl: 'views/login.html',
        controller: 'loginCtrl',
        controllerAs: ''
      })
      .when('/repertorio', {
        templateUrl: 'views/repertorio.html',
        controller: 'cancionCtrl'
      })

      .when('/contrato',{
        templateUrl:'views/contrato.html',
        controller:'contratoCtrl',

      })
      .when('/evento',{
                templateUrl:'views/eventoCatalogo.html',
                controller:'eventoCatalogoCtrl',

              })
              .when('/agenda',{
        templateUrl:'views/agenda.html',
        controller:'agendaCtrl'
      }).otherwise({
        redirectTo: '/'
      });
  });
