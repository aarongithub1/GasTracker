angular.module('appModule')
	.component('gasTracker', {
		templateUrl : 'app/appModule/gasTracker/gasTracker.component.html',
		controllerAs : 'vm',
		controller : function(gasService) {
			
			var vm = this;
			
			vm.selected = null;
			
			vm.gas = [];
			
			// Reload Updated List
			var reload = function() {
				gasService.index()
				.then(function(res){
					vm.gas = res.data;
				})
			}
			
			reload();
			
			//----------- On Click -----------//
			
			// Show Detailed view of item
			vm.detailGas = function(item) {
				vm.selected = item;
			}
			
			//back button - show table
			vm.displayTable = function() {
				vm.selected = null;
			}
			
			//edit button - show edit form
			vm.setEditGas = function(selected) {
				vm.editGas =  angular.copy(selected);
			}
			
			//cancel button - hide edit form
			vm.setEditNull = function() {
				vm.editGas = null;
			}
			
			//------------- CUD --------------//
			
			// Create Gas Item
			vm.createItem = function(createGas) {
				var gas = angular.copy(createGas);
				gasService.create(gas)
					.then(function(res){
						reload();
				})
			}
			
			//update gas item
			vm.updateGas = function(gas) {
				gasService.update(gas)
					.then(function(res){
						reload();
					})
				vm.selected = gas;
				vm.editGas = null;
			}
			
			//delete gas item
			vm.deleteGas = function(id) {
				gasService.destroy(id)
					.then(function(res){
						reload();
					})
			}
			
			
			
		}
		
	});