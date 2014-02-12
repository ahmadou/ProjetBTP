/**
 * Controller Page Accueil
 */
//Definition
var AccueilController = function () {

};
//Injection des dependances
//LoginController['$inject']=['$scope', '$rootScope', '$location', '$http', '$cookieStore'];
//Binding
btpApp.controller('AccueilController',AccueilController);

/**
 * Controller login
 */
//Definition
var LoginController = function ($scope, $rootScope, $location, $http, $cookieStore) {

	$scope.login = function() {
		$http.post('rest/login/authenticate',JSON.stringify(form2js('loginForm')))
		.success(function(user, status, headers, config) {
			if(user.logged) {
				$rootScope.user = user;
				$cookieStore.put('user', user);
				$location.path("/dashboard");
			} else {
				$scope.user=user;
				$scope.error='Echec de l\'identification';
				$("#loginAlert").fadeIn(400);
			}
		})
		.error(function(data, status, headers, config) {
			$scope.error='Erreur lors de l\'identification';
		});
	};
	$('.close').click('close.bs.alert', function() {
		$('#loginAlert').fadeOut(400);
	});
};
//Injection des dependances
LoginController['$inject']=['$scope', '$rootScope', '$location', '$http', '$cookieStore'];
//Binding
btpApp.controller('LoginController',LoginController);
/* Controller Login */
