(set-logic QF_NRA)
(define-fun T ((%init Bool) ($ok$0 Bool) ($i$0 Int) ($sum$0 Int) ($ok$1 Bool) ($i$1 Int) ($sum$1 Int)) Bool (and (= $i$1 (ite %init 0 (+ 1 $i$0))) (= $sum$1 (+ $i$1 (ite %init 0 $sum$0))) (= $ok$1 (= $sum$1 (div (* $i$1 (+ $i$1 1)) 2)))))
(declare-fun %init () Bool)
(declare-fun $ok$~1 () Bool)
(declare-fun $i$~1 () Int)
(declare-fun $sum$~1 () Int)
; K = 0
(declare-fun $ok$0 () Bool)
(declare-fun $i$0 () Int)
(declare-fun $sum$0 () Int)
(assert (T %init $ok$~1 $i$~1 $sum$~1 $ok$0 $i$0 $sum$0))
(assert true)
(push 1)
(assert (not (=> true $ok$0)))
(check-sat)
(echo "@DONE")
; dfake: sat
; dfake: @DONE
(get-model)
(echo "@DONE")
; dfake: $i$0 : [ ENTIRE ] = [-INFTY, -INFTY]
; dfake: $i$~1 : [ ENTIRE ] = [-INFTY, -INFTY]
; dfake: $sum$0 : [ ENTIRE ] = [-INFTY, -INFTY]
; dfake: $sum$~1 : [ ENTIRE ] = [0, 0]
; dfake: ITE_71 : [ ENTIRE ] = [-INFTY, -INFTY]
; dfake: ITE_78 : [ ENTIRE ] = [0, 0]
; dfake: $ok$0 : Bool = false
; dfake: %init : Bool = false
; dfake: $ok$~1 : Bool = undef
; dfake: 
; dfake: @DONE
(pop 1)
; K = 1
(declare-fun $ok$1 () Bool)
(declare-fun $i$1 () Int)
(declare-fun $sum$1 () Int)
(assert (T false $ok$0 $i$0 $sum$0 $ok$1 $i$1 $sum$1))
(assert true)
(push 1)
(assert (not (=> $ok$0 $ok$1)))
(check-sat)
(echo "@DONE")
; dfake: Error java.lang.IllegalArgumentException: Unknown result: null
; dfake: null
