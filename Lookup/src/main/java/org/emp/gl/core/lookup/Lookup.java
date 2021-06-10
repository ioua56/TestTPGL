package org.emp.gl.core.lookup;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Lookup 
{
    private static final Lookup INSTANCE = new Lookup() ;
	
	private Lookup() {		
	}
	
	static public Lookup getLookup () {
		return INSTANCE ; 
	}
	
    	private Map<Class, Object> services = new HashMap<Class, Object>() ;
	
	public <T> void register (
			Class<? super T> service,
			T instance) {
            //System.out.println("Service has been registerd "+ service.toString());
		services.put(service, instance) ;
	}
	
	public <T> T get(Class<T> service) {
		T instance = (T) (services.get(service)) ;
		return instance ; 
	}
}
