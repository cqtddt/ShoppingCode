package com.shoping.mall.study.volley;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.android.volley.toolbox.HurlStack;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

public class OkHttpStack1 extends HurlStack {

	private final OkUrlFactory okUrlFactory;

	public OkHttpStack1() {
		this(new OkUrlFactory(new OkHttpClient()));
	}

	public OkHttpStack1(OkUrlFactory okUrlFactory) {
		if (okUrlFactory == null) {
			throw new NullPointerException("Client must not be null.");
		}
		this.okUrlFactory = okUrlFactory;
	}

	@Override
	protected HttpURLConnection createConnection(URL url) throws IOException {
		return okUrlFactory.open(url);
	}

}
