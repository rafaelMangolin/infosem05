function Graph(){
	this.vertexs = [];
}

Graph.prototype.addVertex = function(vertex){
	this.vertexs.push(vertex);
}

Graph.prototype.getFirst = function(){
	var result = this.vertexs.filter(function(element){
		return element.distance == 0;
	})
	return result[0];
}

Graph.prototype.getRandom = function(){
	return this.vertexs[Math.floor(Math.random()*5)];
}

module.exports = Graph;