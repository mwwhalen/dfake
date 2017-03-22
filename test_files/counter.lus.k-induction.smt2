(set-logic QF_NRA)
(define-fun T ((%init Bool) ($sum$0 Int) ($prop1$0 Bool) ($sum$1 Int) ($prop1$1 Bool)) Bool (and (= $sum$1 (ite %init 1 (+ $sum$0 1))) (= $prop1$1 (< $sum$1 10))))
(declare-fun %init () Bool)
(declare-fun $sum$~1 () Int)
(declare-fun $prop1$~1 () Bool)
; K = 0
(declare-fun $sum$0 () Int)
(declare-fun $prop1$0 () Bool)
(assert (T %init $sum$~1 $prop1$~1 $sum$0 $prop1$0))
(assert true)
(push 1)
(assert (not (=> true $prop1$0)))
(check-sat)
(echo "@DONE")
; dfake: @DONE
(get-model)
(echo "@DONE")
; dfake: sat
; dfake: 
; dfake: @DONE
