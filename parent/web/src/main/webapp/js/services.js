'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
var services = angular.module('btpApp.services',  ['ngResource']);

services.factory('LoginService', function($resource) {
	
	return $resource('rest/login/:action', {},
			{
				authenticate: {
					method: 'POST',
					params: {'action' : 'authenticate'},
					headers : {'Content-Type': 'application/json', 'Accept' : 'application/json'}
				},
			}
		);
});

