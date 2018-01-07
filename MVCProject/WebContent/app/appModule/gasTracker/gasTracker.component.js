angular.module('appModule')
	.component('gasTracker', {
		templateUrl : 'app/appModule/gasTracker/gasTracker.component.html',
		controllerAs : 'vm',
		controller : function(gasService) {
			
			var vm = this;
			vm.selected = null;
			vm.totalButton = null;
			vm.gas = [];
			
			var zeroTotals = function(){
				vm.totalGal = 0;
				vm.totalPrice = 0;
				vm.totalMiles = 0;
				vm.totalMPG = 0;
				
			}
			
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
				vm.totalButton = null;
			}
			
			//edit button - show edit form
			vm.setEditGas = function(selected) {
				vm.editGas =  angular.copy(selected);
			}
			
			//cancel button - hide edit form
			vm.setEditNull = function() {
				vm.editGas = null;
			}
			
			//show Total Table
			vm.showTotalTable = function() {
				vm.totalButton = 1;
			}
			
			//total all columns
			vm.totalAllColumns = function() {
				zeroTotals();
				vm.gas.forEach(function(val){
					vm.totalGal += val.numGallons;
					vm.totalPrice += val.pricePerGallon;
					vm.totalMiles += val.milesDriven;
					vm.totalMPG += val.mpg;
				})
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