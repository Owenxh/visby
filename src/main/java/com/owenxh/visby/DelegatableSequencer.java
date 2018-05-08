package com.owenxh.visby;

import com.owenxh.visby.support.SequenceDecorateStrategy;
import com.owenxh.visby.util.Assert;

import java.io.Serializable;

/**
 * 可委托的序列号生成器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class DelegatableSequencer extends FormatSequencerSupport implements Sequencer {

    private Sequencer delegated;

    public DelegatableSequencer(Sequencer delegated) {
        super();
        setDelegated(delegated);
    }

    public DelegatableSequencer(Sequencer delegated, SequenceDecorateStrategy strategy) {
        super(strategy);
        setDelegated(delegated);
    }

    private void setDelegated(Sequencer delegated) {
        Assert.notNull(delegated, "[delegated] must not be null");
        this.delegated = delegated;
    }

    @Override
    protected Serializable next0() throws SequenceExhaustedException {
        return delegated.next();
    }
}
