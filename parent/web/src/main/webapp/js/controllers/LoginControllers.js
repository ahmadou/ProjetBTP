/**
 * Controller login
 */
//Definition
var LoginController = function ($scope, $rootScope, $location, $http, $cookieStore) {
	
	$scope.login = function() {
		$http.post('rest/secure/login/authenticate',JSON.stringify(form2js('loginForm')))
		.success(function(user, status, headers, config) {
			$rootScope.user = user;
			$http.defaults.headers.common['X-Auth-Token'] = user.token;
			$cookieStore.put('user', user);
			$location.path("/dashboard");
		  })
		 .error(function(data, status, headers, config) {
			   $scope.error='Erreur lors de l\'identification';
		  });
	};
};
//Injection des dependances
LoginController['$inject']=['$scope', '$rootScope', '$location', '$http', '$cookieStore'];
// Binding
btpApp.controller('LoginController',LoginController);
/* Controller Login */
