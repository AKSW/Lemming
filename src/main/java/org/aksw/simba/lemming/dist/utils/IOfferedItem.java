package org.aksw.simba.lemming.dist.utils;

import java.util.Set;

public interface IOfferedItem <T>{
	public T getPotentialItem();
	public T getPotentialItem(Set<T> setOfRestrictedItems );
	//public double getPotentialProb();
	//public int getPotentialIndex();
}