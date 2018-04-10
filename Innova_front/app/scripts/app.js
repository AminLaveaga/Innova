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
  .module('innovaFrontApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider,$locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider

      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/contrato',{
        templateUrl:'views/contrato.html',
      })
      .otherwise({
        redirectTo: '/'
      });
  });
