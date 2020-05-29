package WebProject.no212;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {

    public static String INIT_PARAMETER_NAME_ENCODING = "encoding";

    public static String DEFAULT_ENCODING = "UTF-8";

    private String encoding;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding(encoding);
        }

        System.out.println("EncodingFilter# 文字エンコーディングを設定しました。");

        // サーブレットを実行
        chain.doFilter(request, response); 

        System.out.println("EncodingFilter# chain.doFilterが実行されました。");
    }

    @Override
    public void init(FilterConfig config) {
        encoding = config.getInitParameter(INIT_PARAMETER_NAME_ENCODING);
        if (encoding == null) {
            System.out.println("EncodingFilter# デフォルトのエンコーディング(UTF-8)を利用します。");
            encoding = DEFAULT_ENCODING;
        } else {
            System.out.println("EncodingFilter# 設定されたエンコーディング(" + encoding
                    + ")を利用します。。");
        }
    }

    @Override
    public void destroy() {
    }

}