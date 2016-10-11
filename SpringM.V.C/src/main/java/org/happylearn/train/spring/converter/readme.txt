1.Converter
	T convert(S source);
从原始类型S转为T
2.ConverterFactory
	<T extends R> Converter<S, T> getConverter(Class<T> targetType);
可以转换S到类型R，R 定义了你可以从S转换到类型的范围，即R的子类。	
3.GenericConverter(通用转化)
4.ConversionService(facade interface， 门面模式的应用“对外暴露统一接口，屏蔽内部实现细节”)
定义一个统一的API在运行时执行类型转换
