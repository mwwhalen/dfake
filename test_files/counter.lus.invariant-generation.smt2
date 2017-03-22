(set-logic QF_NRA)
(define-fun T ((%init Bool) ($sum$0 Int) ($prop1$0 Bool) ($sum$1 Int) ($prop1$1 Bool)) Bool (and (= $sum$1 (ite %init 1 (+ $sum$0 1))) (= $prop1$1 (< $sum$1 10))))
(declare-fun %init () Bool)
; Proposed 6 candidates
(declare-fun $sum$~1 () Int)
(declare-fun $prop1$~1 () Bool)
(declare-fun $sum$0 () Int)
(declare-fun $prop1$0 () Bool)
; K = 1
(push 1)
(assert (T true $sum$~1 $prop1$~1 $sum$0 $prop1$0))
(push 1)
(assert (not (and false $prop1$0 (not $prop1$0) (>= $sum$0 1) (<= $sum$0 1))))
(check-sat)
(echo "@DONE")
