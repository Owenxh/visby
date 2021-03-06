package com.owenxh.visby;

import com.owenxh.visby.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * {@link CombinableSequencer} 基本实现
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/7
 */
public class CombinableSequencerSupport implements CombinableSequencer {

    /**
     * 序列号生成器的组成部分
     */
    private Collection<Sequencer> seqSection = new ArrayList<>();

    public CombinableSequencerSupport() {}

    public static final CombinableSequencerSupport from(CombinableSequencerSupport sourceSequencer) {
        CombinableSequencerSupport destSequencer = new CombinableSequencerSupport();
        destSequencer.with(sourceSequencer.getSeqSection());

        return destSequencer;
    }

    /**
     * {@link #seqSection} getter 方法
     * @return
     */
    protected Collection<Sequencer> getSeqSection() {
        return seqSection;
    }

    @Override
    public CombinableSequencer with(Sequencer combined) {
        Assert.notNull(combined, "[combined] must not be null");

        seqSection.add(combined);
        return this;
    }

    @Override
    public CombinableSequencer with(Collection<Sequencer> combined) {
        Assert.notNull(combined, "[combined] must not be null");

        seqSection.addAll(combined);
        return this;
    }

    @Override
    public CombinableSequencer clear() {
        seqSection.clear();
        return this;
    }

    @Override
    public Serializable next() {
        if (seqSection.isEmpty()) {
            throw new IllegalStateException("[seqSection] must not be empty");
        }

        return next0();
    }

    private Serializable next0() {
        StringBuilder sequenceBuilder = new StringBuilder();

        seqSection.stream().forEach(sequencer -> sequenceBuilder.append(sequencer.next()));
        return sequenceBuilder.toString();
    }
}
