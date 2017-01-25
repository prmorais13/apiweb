//Criação do modulo principal da aplicação
var appCliente = angular.module("appCliente", ['ngRoute']);

//Configuração de rota (navegação entre as páginas)
appCliente.config(function ($routeProvider, $locationProvider){
	
	$routeProvider
		.when("/clientes",{templateUrl:'view/cliente.html',	controller:'clienteController'})
		.otherwise({rediretTo:'/'});
});

	$locationProvider.html5Mode(true);