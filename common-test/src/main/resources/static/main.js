var app = angular.module('commonTest', []);

app.controller("AppCtlr", function($scope, $http){
	
	$scope.questions = [];
	$scope.answers =[];
	$scope.results = [];
	
	$http({
	    method: 'get', 
	    url: 'api/testing'
	}).then(function (response) {
		$scope.questions = response.data;
		$scope.results = angular.copy($scope.questions);		
	},function (error){
	    console.log(error, 'can not get data.');
	});
	
	$scope.saveAnswers = function(){
		  var questionNum = $scope.results.length;
		    for(var i = 0; i < questionNum; i++){
		    	$scope.results[i].answers.length = 0;
		    		if(angular.isDefined($scope.answers[i])) 
		    			$scope.results[i].answers[0] = $scope.answers[i];
		    		else 
		    			$scope.results[i].answers[0] = "atsakymas nepasirinktas";
		    } 
		    $scope.postResults();    
	    console.log($scope.results);    
	  };
	  
	 $scope.postResults = function(){
	  $http({
		  	method: 'post', 
		    url: 'api/testing',
		    data: angular.toJson($scope.results)
	    })
	    .then(function(response) {

	    }, 
	    function(response) { 
	    	console.log(error, 'can not post data.')
	    }); 
	 }
});