angular.module('appModule')
	.factory('gasService', function($http){
		var service = {};
		
		// index - show all items
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
		
		//edit item by id
		service.update = function(edit){
			return $http({
				method : 'PUT',
				url : 'rest/gas/' + edit.id,
				headers : {
					'Content-Type' : 'application/json'
				},
				data : edit
			})
		};
		
		//delete item by id
		service.destroy = function(id) {
			return $http({
				method : 'DELETE',
				url : 'rest/gas/' + id
			})
				
		};
		
		return service;
	});