var Graph = require('./graph');
var Tree = require('./tree');
var Vertex = require('./vertex');


function initialize(graph){
	var arr = [new Vertex('A'),new Vertex('B'),new Vertex('C'),new Vertex('D'),new Vertex('E'),new Vertex('F')];
	arr[0].addAdjacent([arr[1],arr[4]]);
	arr[1].addAdjacent([arr[0],arr[2],arr[3],arr[5]]);
	arr[2].addAdjacent([arr[1],arr[5]]);
	arr[3].addAdjacent([arr[1]]);
	arr[4].addAdjacent([arr[0],arr[2]]);
	arr[5].addAdjacent([arr[1],arr[2]]);
	var s = Math.floor(Math.random()*5);
	arr.forEach(function(elm,index){
		if(s == index){
			elm.distance = 0;
			elm.state = 1;
		}
		graph.addVertex(elm);
	})
	return graph;
}

function largura(graph,tree){
	graph = initialize(graph);
	var aux = graph.getFirst();
	tree.addFirst(aux);
	while(tree.getSize() != 0){
		var auxAdj = tree.removeFirst();
		console.log(auxAdj.identifier);
		auxAdj.edges.forEach(function(elm){
			console.log('\t',elm.identifier,elm.distance)
			if(elm.state == 0){
				elm.state = 1;
				elm.distance = auxAdj.distance + 1;
				elm.predecessor = auxAdj;
				tree.addFirst(elm);
			}
		})
		auxAdj.state = 2;
	}
	generateToFirst(graph.getRandom());
}

function generateToFirst(obj){
	console.log(obj.identifier, obj.distance);
	if(obj.predecessor != null){
		generateToFirst(obj.predecessor);
	}
}

largura(new Graph(), new Tree());



