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
			$scope.error = 'Aucune donnee trouvee';
		  });
};
//Injection des dependances
MockController['$inject']=['$scope','$http'];
// Binding
btpApp.controller('MockController',MockController);
/* Controller Login */
