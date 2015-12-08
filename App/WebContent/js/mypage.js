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

	.config(['$httpProvider', function($httpProvider) {
	    //initialize get if not there
	    if (!$httpProvider.defaults.headers.get) {
	        $httpProvider.defaults.headers.get = {};
	    }

	    // Answer edited to include suggestions from comments
	    // because previous version of code introduced browser-related errors

	    //disable IE ajax request caching
	    $httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 26 Jul 1997 05:00:00 GMT';
	    // extra
	    $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
	    $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
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
			if(data && data.length > 10){
				data = data.slice(data.length - 10 , data.length);
			}
			ctrl.options.data = data;
		});
		MyPageService.getUser().then(function(user){
			ctrl.user = user;
			$log.log(user);
		});
	}]);