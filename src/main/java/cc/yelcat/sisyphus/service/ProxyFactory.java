package cc.yelcat.sisyphus.service;


public abstract class ProxyFactory<B extends ProxyFactory<B>> {

    public abstract B build();


}
