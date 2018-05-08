package com.owenxh.visby;

/**
 * 具备组合功能的序列号生成器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/7
 */
public interface CombinableSequencer extends Sequencer {

    /**
     * 将 <code>combined</code> 组合进来作为
     * 序列号的一部分，默认添加至序列号尾部。
     * @param combined 组合进来的序列号生成器
     * @return
     */
    Sequencer with(Sequencer combined);
}
