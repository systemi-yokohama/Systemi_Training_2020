package Java_Training.practice100.no214;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.LinkedHashMap;

import jdk.internal.net.http.HttpClientBuilderImpl;
import jdk.internal.net.http.HttpRequestBuilderImpl;
import jdk.internal.net.http.ResponseSubscribers.HttpResponseInputStream;

/*リクエストパラメタ"key"に指定されている値の内容をレスポンスボディにして
レスポンスコード200返すサーブレットを作成せよ。
"key"の指定がない場合はレスポンスコード400としレスポンスボディは空とする。
ヒント：当然考慮すべきポイントに対するケアを行うこと。 */
public class No080 {
	public static void main(String[] args) {
	var client= HttpClient.newBuilder();
	var req=HttpRequest.newBuilder()
	.version(HttpClient.Version.HTTP_1_1)
	.connectTimeout(Duration.parse("PT3S"))
	.setHeader(String key,String value)
	.build();
	}
	public abstract  HttpResponse send(HttpRequest body,HttpResponse.BodyHandler handler){
		if(key==null){
		return  statusCode(200);
		}else{
			return statusCode(400)
		}
	}

	public HttpRequest.Builder POST(HttpRequest.BodyPublisher pub){

	}

	}
