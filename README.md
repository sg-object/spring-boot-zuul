# spring-boot-zuul

## 주요 기능
* Custom Annotation을 활용한 Zuul Filter 등록

## Version
* Spring Boot : 2.2.6.RELEASE
* Zuul : 2.2.2.RELEASE
* Reflections : 0.9.12

## @Filter
* filterType : Zuul Filter Type
* shouldFilter : Filter 작동 여부
* filterOrder : Filter 순서

## Filter 설정 예시
```java

@Filter(filterType = FilterType.POST_TYPE, shouldFilter = true, filterOrder = 1)
public class PostTestFilter extends AbstractFilter {

	private Logger logger = LoggerFactory.getLogger(PostTestFilter.class);
	
	public PostTestFilter(FilterType filterType, boolean shouldFilter, int filterOrder) {
		super(filterType, shouldFilter, filterOrder);
	}

	@Override
	public Object proccess() {
		// TODO Auto-generated method stub
		RequestContext context = getCurrentContext();
		HttpServletRequest request = context.getRequest();
		logger.info("======================================================");
		logger.info(request.getRequestURL().toString());
		logger.info("Proccess Post Filter");
		logger.info("======================================================");
		return null;
	}
	
}

```
