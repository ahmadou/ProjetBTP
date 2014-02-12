/**
 * Controllers pour la secton dashboard
 */

//Definition mock controller
var MockController = function ($scope,$http, $location) {
	
		$http.get('rest/secure/project/getProjectList')
		.success(function(data, status, headers, config) {
			$scope.projectList = data;
		  });
};
//Injection des dependances
MockController['$inject']=['$scope','$http','$location'];
// Binding
btpApp.controller('MockController',MockController);
/* Controller Login */
