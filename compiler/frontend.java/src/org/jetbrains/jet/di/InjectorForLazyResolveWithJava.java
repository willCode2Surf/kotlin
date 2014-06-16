/*
 * Copyright 2010-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.di;

import com.intellij.openapi.project.Project;
import org.jetbrains.jet.context.GlobalContextImpl;
import org.jetbrains.jet.storage.LockBasedStorageManager;
import org.jetbrains.jet.lang.resolve.lazy.declarations.DeclarationProviderFactory;
import org.jetbrains.jet.lang.resolve.BindingTrace;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptorImpl;
import org.jetbrains.jet.lang.PlatformToKotlinClassMap;
import org.jetbrains.jet.lang.resolve.lazy.ResolveSession;
import org.jetbrains.jet.lang.resolve.java.JavaDescriptorResolver;
import org.jetbrains.jet.lang.resolve.kotlin.VirtualFileFinder;
import org.jetbrains.jet.lang.resolve.java.JavaClassFinderImpl;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedExternalSignatureResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.LazyResolveBasedCache;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedErrorReporter;
import org.jetbrains.jet.lang.resolve.java.resolver.PsiBasedMethodSignatureChecker;
import org.jetbrains.jet.lang.resolve.java.resolver.PsiBasedExternalAnnotationResolver;
import org.jetbrains.jet.lang.resolve.java.structure.impl.JavaPropertyInitializerEvaluatorImpl;
import org.jetbrains.jet.lang.resolve.AnnotationResolver;
import org.jetbrains.jet.lang.resolve.calls.CallResolver;
import org.jetbrains.jet.lang.resolve.calls.ArgumentTypeResolver;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingServices;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingComponents;
import org.jetbrains.jet.lang.types.expressions.ControlStructureTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ForLoopConventionsChecker;
import org.jetbrains.jet.lang.reflect.ReflectionTypes;
import org.jetbrains.jet.lang.resolve.calls.CallExpressionResolver;
import org.jetbrains.jet.lang.resolve.DescriptorResolver;
import org.jetbrains.jet.lang.resolve.DelegatedPropertyResolver;
import org.jetbrains.jet.lang.resolve.TypeResolver;
import org.jetbrains.jet.lang.resolve.QualifiedExpressionResolver;
import org.jetbrains.jet.lang.resolve.calls.CallResolverExtensionProvider;
import org.jetbrains.jet.lang.resolve.calls.CandidateResolver;
import org.jetbrains.jet.lang.psi.JetImportsFactory;
import org.jetbrains.jet.lang.resolve.lazy.ScopeProvider;
import org.jetbrains.jet.lang.resolve.ScriptBodyResolver;
import org.jetbrains.jet.lang.resolve.java.lazy.LazyJavaPackageFragmentProvider;
import org.jetbrains.jet.lang.resolve.java.lazy.GlobalJavaResolverContext;
import org.jetbrains.jet.lang.resolve.kotlin.DeserializedDescriptorResolver;
import org.jetbrains.jet.lang.resolve.kotlin.DeserializationGlobalContextForJava;
import org.jetbrains.jet.lang.resolve.kotlin.JavaDescriptorFinder;
import org.jetbrains.jet.lang.resolve.kotlin.AnnotationDescriptorLoader;
import org.jetbrains.jet.lang.resolve.kotlin.DescriptorDeserializersStorage;
import org.jetbrains.jet.lang.resolve.kotlin.ConstantDescriptorLoader;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.InjectorsPackage. DO NOT EDIT! */
@SuppressWarnings("ALL")
public class InjectorForLazyResolveWithJava {
    
    private final Project project;
    private final GlobalContextImpl globalContext;
    private final LockBasedStorageManager lockBasedStorageManager;
    private final DeclarationProviderFactory declarationProviderFactory;
    private final BindingTrace bindingTrace;
    private final ModuleDescriptorImpl module;
    private final PlatformToKotlinClassMap platformToKotlinClassMap;
    private final ResolveSession resolveSession;
    private final JavaDescriptorResolver javaDescriptorResolver;
    private final VirtualFileFinder virtualFileFinder;
    private final JavaClassFinderImpl javaClassFinder;
    private final TraceBasedExternalSignatureResolver traceBasedExternalSignatureResolver;
    private final LazyResolveBasedCache lazyResolveBasedCache;
    private final TraceBasedErrorReporter traceBasedErrorReporter;
    private final PsiBasedMethodSignatureChecker psiBasedMethodSignatureChecker;
    private final PsiBasedExternalAnnotationResolver psiBasedExternalAnnotationResolver;
    private final JavaPropertyInitializerEvaluatorImpl javaPropertyInitializerEvaluator;
    private final AnnotationResolver annotationResolver;
    private final CallResolver callResolver;
    private final ArgumentTypeResolver argumentTypeResolver;
    private final ExpressionTypingServices expressionTypingServices;
    private final ExpressionTypingComponents expressionTypingComponents;
    private final ControlStructureTypingUtils controlStructureTypingUtils;
    private final ExpressionTypingUtils expressionTypingUtils;
    private final ForLoopConventionsChecker forLoopConventionsChecker;
    private final ReflectionTypes reflectionTypes;
    private final CallExpressionResolver callExpressionResolver;
    private final DescriptorResolver descriptorResolver;
    private final DelegatedPropertyResolver delegatedPropertyResolver;
    private final TypeResolver typeResolver;
    private final QualifiedExpressionResolver qualifiedExpressionResolver;
    private final CallResolverExtensionProvider callResolverExtensionProvider;
    private final CandidateResolver candidateResolver;
    private final JetImportsFactory jetImportsFactory;
    private final ScopeProvider scopeProvider;
    private final ScriptBodyResolver scriptBodyResolver;
    private final LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider;
    private final GlobalJavaResolverContext globalJavaResolverContext;
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final DeserializationGlobalContextForJava deserializationGlobalContextForJava;
    private final JavaDescriptorFinder javaDescriptorFinder;
    private final AnnotationDescriptorLoader annotationDescriptorLoader;
    private final DescriptorDeserializersStorage descriptorDeserializersStorage;
    private final ConstantDescriptorLoader constantDescriptorLoader;
    
    public InjectorForLazyResolveWithJava(
        @NotNull Project project,
        @NotNull GlobalContextImpl globalContext,
        @NotNull DeclarationProviderFactory declarationProviderFactory,
        @NotNull BindingTrace bindingTrace
    ) {
        this.project = project;
        this.globalContext = globalContext;
        this.lockBasedStorageManager = globalContext.getStorageManager();
        this.declarationProviderFactory = declarationProviderFactory;
        this.bindingTrace = bindingTrace;
        this.module = org.jetbrains.jet.lang.resolve.java.AnalyzerFacadeForJVM.createJavaModule("<fake-jdr-module>");
        this.platformToKotlinClassMap = module.getPlatformToKotlinClassMap();
        this.resolveSession = new ResolveSession(project, globalContext, getModule(), declarationProviderFactory, bindingTrace);
        this.javaClassFinder = new JavaClassFinderImpl();
        this.virtualFileFinder = org.jetbrains.jet.lang.resolve.kotlin.VirtualFileFinder.SERVICE.getInstance(project);
        this.deserializedDescriptorResolver = new DeserializedDescriptorResolver();
        this.psiBasedExternalAnnotationResolver = new PsiBasedExternalAnnotationResolver();
        this.traceBasedExternalSignatureResolver = new TraceBasedExternalSignatureResolver();
        this.traceBasedErrorReporter = new TraceBasedErrorReporter();
        this.psiBasedMethodSignatureChecker = new PsiBasedMethodSignatureChecker();
        this.lazyResolveBasedCache = new LazyResolveBasedCache();
        this.javaPropertyInitializerEvaluator = new JavaPropertyInitializerEvaluatorImpl();
        this.globalJavaResolverContext = new GlobalJavaResolverContext(lockBasedStorageManager, javaClassFinder, virtualFileFinder, deserializedDescriptorResolver, psiBasedExternalAnnotationResolver, traceBasedExternalSignatureResolver, traceBasedErrorReporter, psiBasedMethodSignatureChecker, lazyResolveBasedCache, javaPropertyInitializerEvaluator);
        this.lazyJavaPackageFragmentProvider = new LazyJavaPackageFragmentProvider(globalJavaResolverContext, getModule());
        this.javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProvider, getModule());
        this.annotationResolver = new AnnotationResolver();
        this.callResolver = new CallResolver();
        this.argumentTypeResolver = new ArgumentTypeResolver();
        this.expressionTypingComponents = new ExpressionTypingComponents();
        this.expressionTypingServices = new ExpressionTypingServices(expressionTypingComponents);
        this.controlStructureTypingUtils = new ControlStructureTypingUtils(expressionTypingServices);
        this.expressionTypingUtils = new ExpressionTypingUtils(expressionTypingServices, callResolver);
        this.forLoopConventionsChecker = new ForLoopConventionsChecker();
        this.reflectionTypes = new ReflectionTypes(getModule());
        this.callExpressionResolver = new CallExpressionResolver();
        this.descriptorResolver = new DescriptorResolver();
        this.delegatedPropertyResolver = new DelegatedPropertyResolver();
        this.typeResolver = new TypeResolver();
        this.qualifiedExpressionResolver = new QualifiedExpressionResolver();
        this.callResolverExtensionProvider = new CallResolverExtensionProvider();
        this.candidateResolver = new CandidateResolver();
        this.jetImportsFactory = new JetImportsFactory();
        this.scopeProvider = new ScopeProvider(getResolveSession());
        this.scriptBodyResolver = new ScriptBodyResolver();
        this.javaDescriptorFinder = new JavaDescriptorFinder(getJavaDescriptorResolver(), lazyJavaPackageFragmentProvider);
        this.annotationDescriptorLoader = new AnnotationDescriptorLoader();
        this.constantDescriptorLoader = new ConstantDescriptorLoader();
        this.deserializationGlobalContextForJava = new DeserializationGlobalContextForJava(lockBasedStorageManager, getModule(), javaDescriptorFinder, annotationDescriptorLoader, constantDescriptorLoader, lazyJavaPackageFragmentProvider);
        this.descriptorDeserializersStorage = new DescriptorDeserializersStorage(lockBasedStorageManager);

        this.resolveSession.setAnnotationResolve(annotationResolver);
        this.resolveSession.setDescriptorResolver(descriptorResolver);
        this.resolveSession.setJetImportFactory(jetImportsFactory);
        this.resolveSession.setQualifiedExpressionResolver(qualifiedExpressionResolver);
        this.resolveSession.setScopeProvider(scopeProvider);
        this.resolveSession.setScriptBodyResolver(scriptBodyResolver);
        this.resolveSession.setTypeResolver(typeResolver);

        javaClassFinder.setProject(project);

        traceBasedExternalSignatureResolver.setExternalAnnotationResolver(psiBasedExternalAnnotationResolver);
        traceBasedExternalSignatureResolver.setProject(project);
        traceBasedExternalSignatureResolver.setTrace(bindingTrace);

        lazyResolveBasedCache.setSession(resolveSession);

        traceBasedErrorReporter.setTrace(bindingTrace);

        psiBasedMethodSignatureChecker.setExternalAnnotationResolver(psiBasedExternalAnnotationResolver);
        psiBasedMethodSignatureChecker.setExternalSignatureResolver(traceBasedExternalSignatureResolver);

        annotationResolver.setCallResolver(callResolver);
        annotationResolver.setStorageManager(lockBasedStorageManager);
        annotationResolver.setTypeResolver(typeResolver);

        callResolver.setArgumentTypeResolver(argumentTypeResolver);
        callResolver.setCandidateResolver(candidateResolver);
        callResolver.setExpressionTypingServices(expressionTypingServices);
        callResolver.setTypeResolver(typeResolver);

        argumentTypeResolver.setExpressionTypingServices(expressionTypingServices);
        argumentTypeResolver.setTypeResolver(typeResolver);

        expressionTypingServices.setAnnotationResolver(annotationResolver);
        expressionTypingServices.setCallExpressionResolver(callExpressionResolver);
        expressionTypingServices.setCallResolver(callResolver);
        expressionTypingServices.setDescriptorResolver(descriptorResolver);
        expressionTypingServices.setExtensionProvider(callResolverExtensionProvider);
        expressionTypingServices.setProject(project);
        expressionTypingServices.setTypeResolver(typeResolver);

        expressionTypingComponents.setCallResolver(callResolver);
        expressionTypingComponents.setControlStructureTypingUtils(controlStructureTypingUtils);
        expressionTypingComponents.setExpressionTypingServices(expressionTypingServices);
        expressionTypingComponents.setExpressionTypingUtils(expressionTypingUtils);
        expressionTypingComponents.setForLoopConventionsChecker(forLoopConventionsChecker);
        expressionTypingComponents.setGlobalContext(globalContext);
        expressionTypingComponents.setPlatformToKotlinClassMap(platformToKotlinClassMap);
        expressionTypingComponents.setReflectionTypes(reflectionTypes);

        forLoopConventionsChecker.setExpressionTypingServices(expressionTypingServices);
        forLoopConventionsChecker.setExpressionTypingUtils(expressionTypingUtils);
        forLoopConventionsChecker.setProject(project);

        callExpressionResolver.setExpressionTypingServices(expressionTypingServices);

        descriptorResolver.setAnnotationResolver(annotationResolver);
        descriptorResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        descriptorResolver.setExpressionTypingServices(expressionTypingServices);
        descriptorResolver.setStorageManager(lockBasedStorageManager);
        descriptorResolver.setTypeResolver(typeResolver);

        delegatedPropertyResolver.setCallResolver(callResolver);
        delegatedPropertyResolver.setExpressionTypingServices(expressionTypingServices);

        typeResolver.setAnnotationResolver(annotationResolver);
        typeResolver.setModuleDescriptor(module);
        typeResolver.setQualifiedExpressionResolver(qualifiedExpressionResolver);

        candidateResolver.setArgumentTypeResolver(argumentTypeResolver);

        jetImportsFactory.setProject(project);

        scriptBodyResolver.setExpressionTypingServices(expressionTypingServices);

        deserializedDescriptorResolver.setContext(deserializationGlobalContextForJava);
        deserializedDescriptorResolver.setErrorReporter(traceBasedErrorReporter);

        annotationDescriptorLoader.setErrorReporter(traceBasedErrorReporter);
        annotationDescriptorLoader.setKotlinClassFinder(virtualFileFinder);
        annotationDescriptorLoader.setModule(module);
        annotationDescriptorLoader.setStorage(descriptorDeserializersStorage);

        descriptorDeserializersStorage.setErrorReporter(traceBasedErrorReporter);
        descriptorDeserializersStorage.setModule(module);

        constantDescriptorLoader.setErrorReporter(traceBasedErrorReporter);
        constantDescriptorLoader.setKotlinClassFinder(virtualFileFinder);
        constantDescriptorLoader.setStorage(descriptorDeserializersStorage);

        javaClassFinder.initialize();

    }
    
    @PreDestroy
    public void destroy() {
    }
    
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }
    
    public ResolveSession getResolveSession() {
        return this.resolveSession;
    }
    
    public JavaDescriptorResolver getJavaDescriptorResolver() {
        return this.javaDescriptorResolver;
    }
    
}
