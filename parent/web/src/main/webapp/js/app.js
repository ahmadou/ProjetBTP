'use strict';


// Declare app level module which depends on filters, and services
angular.module('btpApp', [
  'ngRoute',
  'ngCookies',
  'myApp.filters',
  'btpApp.services',
  'myApp.directives',
]).
config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
	$routeProvider
	.when('/dashboard', {
		templateUrl: 'partials/dashboard.html',
		controller: 'MockController'
	})
	.when('/about', {
		templateUrl: 'partials/dashboard.html',
		controller: 'MockController'
	});
	
	$routeProvider.otherwise({
		templateUrl: 'partials/accueil.html',
		controller: 'AccueilController'
	});

	/* Intercepter les erreurs http .
	 * Une erreur 401 redirige automatiquement vers la page d'accueil
	 * */
	var interceptor = function ($rootScope, $q, $location) {

        function success(response) {
            return response;
        }

        function error(response) {

            var status = response.status;
            var config = response.config;
            var method = config.method;
            var url = config.url;

            if (status == 401) {
            	$location.path( "/#" );
            } else {
            	$rootScope.error = method + " sur " + url + " a echoue avec le statut " + status;
            }

            return $q.reject(response);
        }

        return function (promise) {
            return promise.then(success, error);
        };
    };
    $httpProvider.responseInterceptors.push(interceptor);

}])
.run(function($rootScope) {

	
	$rootScope.$on('$viewContentLoaded', function() {
		delete $rootScope.error;
	});

	/*
	 * Determine si le user actuellement connecte dispose de l habilitation role
	 */
	$rootScope.hasRole = function(role) {

		if ($rootScope.user === undefined) {
			return false;
		}

		if ($rootScope.user.roles[role] === undefined) {
			return false;
		}

		return $rootScope.user.roles[role];
	};

});
;
