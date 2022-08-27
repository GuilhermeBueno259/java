package collectors;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// A interface Collector nada mais é do que uma junção de várias interfaces funcionais
public class InterfaceCollector implements Collector<String, Double, Integer> {
	@Override
	public Supplier<Double> supplier() {
		return null;
	}

	@Override
	public BiConsumer<Double, String> accumulator() {
		return null;
	}

	@Override
	public BinaryOperator<Double> combiner() {
		return null;
	}

	@Override
	public Function<Double, Integer> finisher() {
		return null;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return null;
	}
}
