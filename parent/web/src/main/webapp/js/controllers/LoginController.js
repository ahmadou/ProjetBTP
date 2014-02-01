/**
 * Controller login
 */
//Definition
var LoginController = function ($scope, $rootScope, $location, $http, $cookieStore) {
	
	$scope.login = function() {
		$http.post('rest/login/authenticate','{"identifiant":"'+$scope.identifiant+'", "password":"'+$scope.password+'"}"')
		.success(function(user, status, headers, config) {
			$rootScope.user = user;
			$http.defaults.headers.common['X-Auth-Token'] = user.token;
			$cookieStore.put('user', user);
			$location.path("/");
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
