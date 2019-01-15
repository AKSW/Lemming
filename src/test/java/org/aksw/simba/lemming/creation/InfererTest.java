package org.aksw.simba.lemming.creation;
import java.util.Map;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.junit.Test;

import junit.framework.Assert;

public class InfererTest {

	@Test
	public void test() {
		String ttlFileName = "test.ttl";
		//using the full dbpedia_2015-04.owl 
		String folderPath = "person_graph";
		
		Inferer inferer = new Inferer();

		Model personModel = ModelFactory.createDefaultModel();
		personModel.read(ttlFileName, "TTL");
		
		Map <String, String> map = inferer.mapModel2Ontology();
		
		Model actualModel = inferer.process(personModel, map, ttlFileName, folderPath);
		Model expModel = ModelFactory.createDefaultModel();
		
		expModel.read("expected.ttl", "TTL");
		
		Assert.assertEquals(true, actualModel.isIsomorphicWith(expModel));

	}
}