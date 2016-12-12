/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.context.activator;

import javax.annotation.Priority;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.Unbound;
import org.jboss.weld.manager.BeanManagerImpl;

/** Uses CDI API binding - @javax.enterprise.context.control.ActivateRequestContext.
 *
 * @author <a href="mailto:manovotn@redhat.com">Matej Novotny</a>
 */
@Vetoed
@Interceptor
@ActivateRequestContext
@SuppressWarnings("checkstyle:magicnumber")
@Priority(Interceptor.Priority.PLATFORM_BEFORE + 100)
public class CdiRequestContextActivatorInterceptor extends AbstractActivateRequestContextInterceptor {

    @Inject
    public CdiRequestContextActivatorInterceptor(@Unbound RequestContext requestContext, BeanManagerImpl beanManager) {
        super(requestContext, beanManager);
    }
}
