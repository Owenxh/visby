package com.owenxh.visby;

import com.owenxh.visby.util.Assert;
import com.owenxh.visby.util.NumberUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Int 递增序列号
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class IntIncrementSequencer extends IncrementableSequencer<Integer> implements Sequencer {

    private AtomicInteger internalSequencer;

    public IntIncrementSequencer() {
        this(0);
    }

    public IntIncrementSequencer(int startSequence) {
        this(0, Integer.MAX_VALUE, 1, true, startSequence);
    }

    public IntIncrementSequencer(int minSequence, int maxSequence, int incrementStep, boolean looped, int startSequence) {
        super(minSequence, maxSequence, incrementStep, looped);

        Assert.nonNegative(startSequence, "[startSequence] must not be negative");

        this.internalSequencer = new AtomicInteger(startSequence);
    }

    @Override
    protected Integer next0() throws SequenceExhaustedException {
        int next = internalSequencer.getAndAdd(getIncrementStep());

        if (NumberUtils.isNegative(next)) {
            throw new SequenceExhaustedException();
        }

        return next;
    }

    @Override
    protected void reset() {
        this.internalSequencer.set(getMinSequence());
    }

}
