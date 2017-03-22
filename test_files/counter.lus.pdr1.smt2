(set-option :produce-interpolants true)
(set-option :produce-unsat-cores true)
(set-option :simplify-interpolants true)
(set-logic QF_UFLIRA)
(set-option :verbosity 2)
(declare-fun $sum () Int)
(declare-fun $prop1 () Bool)
(declare-fun %init () Bool)
(declare-fun $sum- () Int)
(declare-fun $prop1- () Bool)
(declare-fun %init- () Bool)
(declare-fun |$sum-'| () Int)
(declare-fun |$prop1-'| () Bool)
(declare-fun |%init-'| () Bool)
(declare-fun |$sum'| () Int)
(declare-fun |$prop1'| () Bool)
(declare-fun |%init'| () Bool)
(define-fun T (($sum Int) ($prop1 Bool) (%init Bool) (|$sum'| Int) (|$prop1'| Bool) (|%init'| Bool)) Bool (and (= |$sum'| (ite %init 1 (+ $sum 1))) (= |$prop1'| (< |$sum'| 10)) (not |%init'|)))
(assert (! (T $sum- $prop1- %init- |$sum-'| |$prop1-'| |%init-'|) :named abstract0))
(echo "New predicate: %init")
(assert (! (= %init %init-) :named abstract1))
(assert (! (= |%init-'| |%init'|) :named abstract2))
(echo "New predicate: $prop1")
(assert (! (= $prop1 $prop1-) :named abstract3))
(assert (! (= |$prop1-'| |$prop1'|) :named abstract4))
(echo "Checking property: prop1")
(push 1)
(assert (and %init (not (or $prop1 %init))))
(check-sat)
(pop 1)
(echo "Number of frames: 3")
(push 1)
(assert (not (or $prop1 %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and (not $prop1) (not %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not $prop1) (not %init))))
(assert (! %init :named F0))
(assert (! true :named F1))
(assert true)
(assert (! (not |$prop1'|) :named P0))
(assert (! (not |%init'|) :named P1))
(check-sat)
(get-unsat-core)
(pop 1)
(push 1)
(assert %init)
(assert (! %init :named F0))
(assert (! true :named F1))
(assert true)
(assert (! (not |%init'|) :named P0))
(check-sat)
(pop 1)
(echo "Blocked [1] : [(not $prop1), (not %init)]")
(push 1)
(assert (and (not (and (not $prop1) (not %init))) (not (or $prop1 %init))))
(check-sat)
(pop 1)
(echo "Number of frames: 4")
(push 1)
(assert (! (not (and (not $prop1) (not %init))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! (not |$prop1'|) :named P0))
(assert (! (not |%init'|) :named P1))
(check-sat)
(pop 1)
(push 1)
(assert (not (or $prop1 %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and (not $prop1) (not %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not $prop1) (not %init))))
(assert (! (not (and (not $prop1) (not %init))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! (not |$prop1'|) :named P0))
(assert (! (not |%init'|) :named P1))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and $prop1 (not %init) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and $prop1 (not %init))))
(assert (! %init :named F0))
(assert (! (not (and (not $prop1) (not %init))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! |$prop1'| :named P0))
(assert (! (not |%init'|) :named P1))
(check-sat)
(get-model)
(pop 1)
(declare-fun $sum$~1 () Int)
(declare-fun $prop1$~1 () Bool)
(declare-fun %init$~1 () Bool)
(declare-fun $sum$0 () Int)
(declare-fun $prop1$0 () Bool)
(declare-fun %init$0 () Bool)
(declare-fun $sum$1 () Int)
(declare-fun $prop1$1 () Bool)
(declare-fun %init$1 () Bool)
(push 1)
(assert (! (and (not $prop1$~1) %init$~1 (T $sum$~1 $prop1$~1 %init$~1 $sum$0 $prop1$0 %init$0)) :named I0))
(assert (! (and $prop1$0 (not %init$0) (T $sum$0 $prop1$0 %init$0 $sum$1 $prop1$1 %init$1)) :named I1))
(assert (! (and (not $prop1$1) (not %init$1) (not (or $prop1$1 %init$1))) :named I2))
(check-sat)
(get-interpolants I0 I1 I2 (and abstract0 abstract1 abstract2 abstract3 abstract4))
(pop 1)
(echo "New predicate: (<= $sum 1)")
(assert (! (= (<= $sum 1) (<= $sum- 1)) :named abstract5))
(assert (! (= (<= |$sum-'| 1) (<= |$sum'| 1)) :named abstract6))
(echo "Refined abstraction")
(push 1)
(assert (not (or $prop1 %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and (not $prop1) (not (<= $sum 1)) (not %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not $prop1) (not (<= $sum 1)) (not %init))))
(assert (! (not (and (not $prop1) (not %init))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! (not |$prop1'|) :named P0))
(assert (! (not (<= |$sum'| 1)) :named P1))
(assert (! (not |%init'|) :named P2))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and $prop1 (not (<= $sum 1)) (not %init) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and $prop1 (not (<= $sum 1)) (not %init))))
(assert (! %init :named F0))
(assert (! (not (and (not $prop1) (not %init))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! |$prop1'| :named P0))
(assert (! (not (<= |$sum'| 1)) :named P1))
(assert (! (not |%init'|) :named P2))
(check-sat)
(get-unsat-core)
(pop 1)
(push 1)
(assert %init)
(assert (! %init :named F0))
(assert (! (not (and (not $prop1) (not %init))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! (not |%init'|) :named P0))
(check-sat)
(pop 1)
(echo "Blocked [1] : [(not (<= $sum 1)), (not %init)]")
(push 1)
(assert (and (not $prop1) (not (<= $sum 1)) (not %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not $prop1) (not (<= $sum 1)) (not %init))))
(assert (! (and (not (and (not (<= $sum 1)) (not %init))) (not (and (not $prop1) (not %init)))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! (not |$prop1'|) :named P0))
(assert (! (not (<= |$sum'| 1)) :named P1))
(assert (! (not |%init'|) :named P2))
(check-sat)
(get-unsat-core)
(pop 1)
(push 1)
(assert %init)
(assert (! (and (not (and (not (<= $sum 1)) (not %init))) (not (and (not $prop1) (not %init)))) :named F1))
(assert (! true :named F2))
(assert true)
(assert (! (not |%init'|) :named P0))
(check-sat)
(pop 1)
(echo "Blocked [2] : [(not $prop1), (not %init)]")
(push 1)
(assert (and $prop1 (not (<= $sum 1)) (not %init) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and $prop1 (not (<= $sum 1)) (not %init))))
(assert (! (not (and (not (<= $sum 1)) (not %init))) :named F1))
(assert (! (not (and (not $prop1) (not %init))) :named F2))
(assert true)
(assert (! |$prop1'| :named P0))
(assert (! (not (<= |$sum'| 1)) :named P1))
(assert (! (not |%init'|) :named P2))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and $prop1 (<= $sum 1) (not %init) (not (and (not (<= $sum 1)) (not %init))) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and $prop1 (<= $sum 1) (not %init))))
(assert (! %init :named F0))
(assert (! (not (and (not (<= $sum 1)) (not %init))) :named F1))
(assert (! (not (and (not $prop1) (not %init))) :named F2))
(assert true)
(assert (! |$prop1'| :named P0))
(assert (! (<= |$sum'| 1) :named P1))
(assert (! (not |%init'|) :named P2))
(check-sat)
(get-model)
(pop 1)
(declare-fun $sum$2 () Int)
(declare-fun $prop1$2 () Bool)
(declare-fun %init$2 () Bool)
(push 1)
(assert (! (and (not $prop1$~1) (not (<= $sum$~1 1)) %init$~1 (T $sum$~1 $prop1$~1 %init$~1 $sum$0 $prop1$0 %init$0)) :named I0))
(assert (! (and $prop1$0 (<= $sum$0 1) (not %init$0) (T $sum$0 $prop1$0 %init$0 $sum$1 $prop1$1 %init$1)) :named I1))
(assert (! (and $prop1$1 (not (<= $sum$1 1)) (not %init$1) (T $sum$1 $prop1$1 %init$1 $sum$2 $prop1$2 %init$2)) :named I2))
(assert (! (and (not $prop1$2) (not (<= $sum$2 1)) (not %init$2) (not (or $prop1$2 %init$2))) :named I3))
(check-sat)
(get-interpolants I0 I1 I2 I3 (and abstract0 abstract1 abstract2 abstract3 abstract4 abstract5 abstract6))
(pop 1)
(echo "New predicate: (<= $sum 2)")
(assert (! (= (<= $sum 2) (<= $sum- 2)) :named abstract7))
(assert (! (= (<= |$sum-'| 2) (<= |$sum'| 2)) :named abstract8))
(echo "Refined abstraction")
(push 1)
(assert (and (not (and (not $prop1) (not %init))) (not (or $prop1 %init))))
(check-sat)
(pop 1)
(echo "Number of frames: 5")
(push 1)
(assert (! (not (and (not (<= $sum 1)) (not %init))) :named F1))
(assert (! (not (and (not $prop1) (not %init))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not (<= |$sum'| 1)) :named P0))
(assert (! (not |%init'|) :named P1))
(check-sat)
(pop 1)
(push 1)
(assert (! (not (and (not $prop1) (not %init))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not |$prop1'|) :named P0))
(assert (! (not |%init'|) :named P1))
(check-sat)
(pop 1)
(push 1)
(assert (not (or $prop1 %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and (not (<= $sum 2)) (not $prop1) (not (<= $sum 1)) (not %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not (<= $sum 2)) (not $prop1) (not (<= $sum 1)) (not %init))))
(assert (! (not (and (not $prop1) (not %init))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not (<= |$sum'| 2)) :named P0))
(assert (! (not |$prop1'|) :named P1))
(assert (! (not (<= |$sum'| 1)) :named P2))
(assert (! (not |%init'|) :named P3))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and (not (<= $sum 2)) $prop1 (not (<= $sum 1)) (not %init) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not (<= $sum 2)) $prop1 (not (<= $sum 1)) (not %init))))
(assert (! (not (and (not (<= $sum 1)) (not %init))) :named F1))
(assert (! (not (and (not $prop1) (not %init))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not (<= |$sum'| 2)) :named P0))
(assert (! |$prop1'| :named P1))
(assert (! (not (<= |$sum'| 1)) :named P2))
(assert (! (not |%init'|) :named P3))
(check-sat)
(get-unsat-core)
(pop 1)
(push 1)
(assert %init)
(assert (! (not (and (not (<= $sum 1)) (not %init))) :named F1))
(assert (! (not (and (not $prop1) (not %init))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not |%init'|) :named P0))
(check-sat)
(pop 1)
(echo "Blocked [2] : [(not (<= $sum 2)), (not %init)]")
(push 1)
(assert (and (not (<= $sum 2)) (not $prop1) (not (<= $sum 1)) (not %init)))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not (<= $sum 2)) (not $prop1) (not (<= $sum 1)) (not %init))))
(assert (! (and (not (and (not $prop1) (not %init))) (not (and (not (<= $sum 2)) (not %init)))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not (<= |$sum'| 2)) :named P0))
(assert (! (not |$prop1'|) :named P1))
(assert (! (not (<= |$sum'| 1)) :named P2))
(assert (! (not |%init'|) :named P3))
(check-sat)
(get-unsat-core)
(pop 1)
(push 1)
(assert (not (and (not $prop1) (not %init))))
(assert (! (and (not (and (not $prop1) (not %init))) (not (and (not (<= $sum 2)) (not %init)))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not |$prop1'|) :named P0))
(assert (! (not |%init'|) :named P1))
(check-sat)
(get-unsat-core)
(pop 1)
(push 1)
(assert %init)
(assert (! (and (not (and (not $prop1) (not %init))) (not (and (not (<= $sum 2)) (not %init)))) :named F2))
(assert (! true :named F3))
(assert true)
(assert (! (not |%init'|) :named P0))
(check-sat)
(pop 1)
(echo "Blocked [3] : [(not $prop1), (not %init)]")
(push 1)
(assert (and (not (<= $sum 2)) $prop1 (not (<= $sum 1)) (not %init) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (not (<= $sum 2)) $prop1 (not (<= $sum 1)) (not %init))))
(assert (! (not (and (not (<= $sum 2)) (not %init))) :named F2))
(assert (! (not (and (not $prop1) (not %init))) :named F3))
(assert true)
(assert (! (not (<= |$sum'| 2)) :named P0))
(assert (! |$prop1'| :named P1))
(assert (! (not (<= |$sum'| 1)) :named P2))
(assert (! (not |%init'|) :named P3))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and (<= $sum 2) $prop1 (not (<= $sum 1)) (not %init) (not (and (not (<= $sum 2)) (not %init))) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (<= $sum 2) $prop1 (not (<= $sum 1)) (not %init))))
(assert (! (not (and (not (<= $sum 1)) (not %init))) :named F1))
(assert (! (not (and (not (<= $sum 2)) (not %init))) :named F2))
(assert (! (not (and (not $prop1) (not %init))) :named F3))
(assert true)
(assert (! (<= |$sum'| 2) :named P0))
(assert (! |$prop1'| :named P1))
(assert (! (not (<= |$sum'| 1)) :named P2))
(assert (! (not |%init'|) :named P3))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (and (<= $sum 2) $prop1 (<= $sum 1) (not %init) (not (and (not (<= $sum 1)) (not %init))) (not (and (not (<= $sum 2)) (not %init))) (not (and (not $prop1) (not %init)))))
(check-sat)
(get-model)
(pop 1)
(push 1)
(assert (not (and (<= $sum 2) $prop1 (<= $sum 1) (not %init))))
(assert (! %init :named F0))
(assert (! (not (and (not (<= $sum 1)) (not %init))) :named F1))
(assert (! (not (and (not (<= $sum 2)) (not %init))) :named F2))
(assert (! (not (and (not $prop1) (not %init))) :named F3))
(assert true)
(assert (! (<= |$sum'| 2) :named P0))
(assert (! |$prop1'| :named P1))
(assert (! (<= |$sum'| 1) :named P2))
(assert (! (not |%init'|) :named P3))
(check-sat)
(get-model)
(pop 1)
(declare-fun $sum$3 () Int)
(declare-fun $prop1$3 () Bool)
(declare-fun %init$3 () Bool)
(push 1)
(assert (! (and (not (<= $sum$~1 2)) (not $prop1$~1) (not (<= $sum$~1 1)) %init$~1 (T $sum$~1 $prop1$~1 %init$~1 $sum$0 $prop1$0 %init$0)) :named I0))
(assert (! (and (<= $sum$0 2) $prop1$0 (<= $sum$0 1) (not %init$0) (T $sum$0 $prop1$0 %init$0 $sum$1 $prop1$1 %init$1)) :named I1))
(assert (! (and (<= $sum$1 2) $prop1$1 (not (<= $sum$1 1)) (not %init$1) (T $sum$1 $prop1$1 %init$1 $sum$2 $prop1$2 %init$2)) :named I2))
