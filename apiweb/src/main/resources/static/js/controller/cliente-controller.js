//Criacao de controllers
appCliente.controller("clienteController", function($scope, $http){

	$scope.clientes = [];
	$scope.cliente = {};
	
	
	carregarClientes =  function (){
		$http({method:'GET', url:'http://localhost:8080/clientes'})
		.then(function(response){
			
			$scope.clientes = response.data;
			
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
	};
			
	$scope.gravarCliente = function(){
		
		$http({method:'POST', url:'http://localhost:8080/clientes', data:$scope.cliente})
		.then(function(response){
			
			//$scope.clientes.push(response.data);
			carregarClientes();
			$scope.cancelar();
	
			
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
		
	};
	
	$scope.excluirCliente = function(cliente){
		
		$http({method:'DELETE', url:'http://localhost:8080/clientes/' + cliente.id})
		.then(function(response){
			
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos, 1);
			
			/*for(i = 0; i < $scope.clientes.length; i++){				
				
				if($scope.clientes[i] == cliente.id){
					$scope.clientes.splice(i, 1);
					break;
				}
			}*/
			
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
		
		
	};
	
	$scope.editarCliente = function(cliente){

		$scope.cliente = angular.copy(cliente);

	};
	
	$scope.cancelar = function(){

		$scope.cliente = {};		

	};
	
	carregarClientes();
	
});