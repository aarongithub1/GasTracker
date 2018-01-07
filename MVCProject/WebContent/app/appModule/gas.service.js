angular.module('appModule')
	.factory('gasService', function($http){
		var service = {};
		
		// public
		service.index = function() {
			return $http({
				method : 'GET',
				url : 'rest/gas'
			})
		};
		
		// create list item
		service.create = function(gas) {
			return $http({
				method : 'POST',
				url : 'rest/gas',
				headers : {
			        'Content-Type' : 'application/json'
			      },
			      data : gas
			})
		};
		
		return service;
	});