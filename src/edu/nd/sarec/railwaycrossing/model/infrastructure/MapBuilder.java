package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;

/**
 * Creates all infrastructure for the simulation
 * @author jane
 * Added Additional Train and assigned roads to factories and gates
 * @edited by Michael
 */
public class MapBuilder {
	HashMap<String, Road> roads;
	HashMap<String, CrossingGate> gates;
	HashMap<String, RailwayTracks> tracks;
	
	public MapBuilder(){
		roads = new HashMap<String,Road>();	
		gates = new HashMap<String,CrossingGate>();
		tracks = new HashMap<String,RailwayTracks>();
		buildRoads();
		buildCrossingGates();
		buildTracks();
		assignGatesToRoads();
		buildCarFactories();
	}

	private void buildRoads(){
		roads.put("Western Highway",new Road(new Point(800,0),new Point (800,1000),Direction.SOUTH,true,false));
		roads.put("Skyway",new Road(new Point(400,0),new Point (400,1000),Direction.SOUTH,true,false));		
		roads.put("EastWest",new Road(new Point(415,200),new Point (785,200),Direction.EAST,true,true));
	}
	
	private void buildCrossingGates(){
		gates.put("Gate1", new CrossingGate(780,480, "Gate1"));
		gates.put("Gate2", new CrossingGate(380,480, "Gate2"));		
	}
	
	private void buildTracks(){
		tracks.put("Royal", new RailwayTracks(new Point(0,500),new Point(1200,500)));
		tracks.put("Royal2", new RailwayTracks(new Point(0,530),new Point(1200,530)));
	}
	
	private void assignGatesToRoads(){
		//Have roads assigned to gate
		roads.get("Western Highway").assignGate(gates.get("Gate1"), roads.get("Western Highway").getCarFactory());
		roads.get("Skyway").assignGate(gates.get("Gate2"), roads.get("Skyway").getCarFactory());
	}
	
	private void buildCarFactories(){
		//Have roads assigned to car factory
		//sky way must come first because only one car factory after car leaves junction will be assigned to western road
		roads.get("Skyway").addCarFactory(roads.get("Western Highway").getCarFactory());
		roads.get("Western Highway").addCarFactory(roads.get("Skyway").getCarFactory());
	}
	
	public Collection<CrossingGate> getAllGates(){
		return gates.values();
	}
	
	public Collection<RailwayTracks> getTracks(){
		return tracks.values();
	}
	
	public Collection<Road> getRoads(){
		return roads.values();
	}
	
	public RailwayTracks getTrack(String name){
		return tracks.get(name);
	}
}
