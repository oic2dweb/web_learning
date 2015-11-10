angular.module('app', ['ngRoute', 'angularChart'])

	.config(['$routeProvider', function($routeProvider){
		$routeProvider.when('/mypage', {
			templateUrl:CONTEXT_PATH + 'routing?dest=testRecords',
		})
		.when('/userUpdate', {
			templateUrl:CONTEXT_PATH + 'routing?dest=userUpdate'
		})
		.when('/testRecords', {
			templateUrl:CONTEXT_PATH + 'routing?dest=testRecords'
		});
	}])

	.service('MyPageService', ['$http', '$log', function($http, $log){
		var service = this;
		var data = {};
		var dimensions = {};

		var getUser = function(){
			return $http({
				method:'POST',
				url:CONTEXT_PATH + 'rest/user/userinfo',
			})
			.then(function(response){
				return response.data;
			});
		}
		var getAllTestRecords = function(){
			return $http({
				method:'GET',
				url:CONTEXT_PATH + 'rest/mypage/testRecords/all',
			})
			.then(function(response){
				return response.data;
			});
		};

		dimensions = {
			percentage:{
				axis:'y',
				type:'line',
				color:'black',
				name:'点数',
				postfix:'%',
			},
			times:{
				axis:'x',
				prefix:'第',
				postfix:'回',
			},
		};

		service.getUser = getUser;
		service.options = {
				data: data,
				dimensions : dimensions,
				chart:{axis:{y:{max:100, min:0, padding:{top:0, bottom:0}}}},
			};
		service.getAllTestRecords = getAllTestRecords;
	}])

	.controller('MyPageController', ['MyPageService', '$log',function(MyPageService, $log){
		var ctrl = this;
		ctrl.options = MyPageService.options;
		MyPageService.getAllTestRecords().then(function(data){
			for(i = 0; i < data.length; i++){
				data[i].times = i+1;
			}
			ctrl.options.data = data;
		});
		MyPageService.getUser().then(function(user){
			ctrl.user = user;
		});
	}]);