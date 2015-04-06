function Vertex(identifier){
	this.identifier = identifier;
	this.edges = [];
	this.state = 0;
	this.distance = -1;
	this.predecessor = null;
}

Vertex.prototype.addAdjacent = function(array){
	var edges = this.edges;
	array.forEach(function(elm){
		edges.push(elm);
	})
}

module.exports = Vertex;