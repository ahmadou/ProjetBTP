'use strict';


// Declare app level module which depends on filters, and services
angular.module('btpApp', [
  'ngRoute',
  'ngCookies',
  'myApp.filters',
  'btpApp.services',
  'myApp.directives',
]).
config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/login', {
		templateUrl: 'partials/login.html',
		controller: 'LoginController'
	})
	.when('dashboard', {
		templateUrl: 'partials/dashboard.html',
		controller: 'DashBoardController'
	});
}]);
