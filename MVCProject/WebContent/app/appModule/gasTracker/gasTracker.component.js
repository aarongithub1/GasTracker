angular.module('appModule')
	.component('gasTracker', {
		templateUrl : 'app/appModule/gasTracker/gasTracker.component.html',
		controllerAs : 'vm',
		controller : function(gasService) {
			
			var vm = this;
			
			vm.gas = [];
			
			// Display Updated List
			var reload = function() {
				gasService.index()
				.then(function(res){
					vm.gas = res.data;
				})
			}
			
			reload();
			
			// Create Gas Item
			vm.createItem = function(createGas) {
				var gas = angular.copy(createGas);
				gasService.create(gas)
					.then(function(res){
						reload();
				})
			}
			
			
			
		}
		
	});