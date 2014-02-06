/**
 * Controllers pour la secton dashboard
 */

//Definition mock controller
var MockController = function ($scope,$http) {
	
		$http.get('rest/secure/project/getProjectList')
		.success(function(data, status, headers, config) {
			$scope.projectList = data;
		  })
		  .error(function(data, status, headers, config) {
			if(status=401){
				$scope.error='Votre session a expire';
				$location.path("/");
			}
		  });
};
//Injection des dependances
MockController['$inject']=['$scope','$http'];
// Binding
btpApp.controller('MockController',MockController);
/* Controller Login */
